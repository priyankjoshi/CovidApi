Pull daily COVID-19 data from https://github.com/CSSEGISandData/COVID-19/tree/master/csse_covid_19_data/csse_covid_19_daily_reports
#Parse data and can use temporary storage in cache/DB as see fit (not a mandate though).
#Expose Rest APIs to provide data for COVID-19 Dashboard: 
 1.For number of Active, Confirmed, Deaths, Recovered, Incident Rate, Case Fatality Ratio  (Details about can be found @ above link) based
  on City, Country, Date filters and Frequency (Daily, Weekly, Monthly)
 2.To provide list of Containment Zone based on Active cases above a threshold value.
 3.To indicate whether a region is ready to work from office based on latitude , longitude, radius in Kilometers, total population within that region, threshold in %age. These parameters will be input to Rest API.
    A region is ready to work from office if %age of active cases (w.r.t total population of that area) is below threshold in %age.
 