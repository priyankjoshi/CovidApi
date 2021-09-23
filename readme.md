#Covid API
This is a spring boot application which expose Endpoint to get the data using filters like country and date.

COVID-19 data can be pulled from from https://github.com/CSSEGISandData/COVID-19/tree/master/csse_covid_19_data/csse_covid_19_daily_reports

The application exposes below endpoint to get the Data-

1. Get covid data using Country Filter- localhost:8080/api/v1/covid/India
2. Get covid data using Date filter - localhost:8080/api/v1/covid/details?date=2021-01-02

This application uses Spring Batch to load the data into DB.
