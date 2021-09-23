package com.cs.covidapi.config;

import com.cs.covidapi.data.CovidData;
import com.cs.covidapi.model.CovidDetails;
import com.cs.covidapi.processor.CovidDataProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    private final String[] FIELD_NAMES = new String[]{
            "FIPS",
            "Admin2","Province_State","Country_Region",
            "Last_Update","Lat","Long_","Confirmed","Deaths",
            "Recovered","Active","Combined_Key","Incident_Rate",
            "Case_Fatality_Ratio"
    };


    @Bean
    public FlatFileItemReader<CovidData> reader() {
        return new FlatFileItemReaderBuilder<CovidData>()
                .name("covidDataReader")
                .resource(new ClassPathResource("/Covid_Data/CovidData.csv")).strict(false)
                .linesToSkip(1)
                .delimited()
                .names(FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<CovidData>(){
                    {
                        setTargetType(CovidData.class);
                    }
                })
                .build();
    }

    @Bean
    public CovidDataProcessor processor() {
        return new CovidDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<CovidDetails> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<CovidDetails>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO covid_details (id,fisp,admin,state,country,last_Update,latitude,longitude,confirmed_Cases,no_Of_Deaths,recovered_Cases,active_Cases,combined_Key,incident_Rate,case_Fatality_Ratio)" +
                        "VALUES (:id,:fisp, :admin, :state, :country, :lastUpdate,:latitude , :longitude, :confirmedCases, :noOfDeaths, :recoveredCases, :activeCases, :combinedKey, :incidentRate, :caseFatalityRatio)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<CovidDetails> writer) {
        return stepBuilderFactory.get("step1")
                .<CovidData, CovidDetails> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
