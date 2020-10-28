package com.BDev.CoronaTracker.services;

import com.BDev.CoronaTracker.models.record;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    private static String UPDATE_URL="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/10-26-2020.csv";
        private ArrayList<record> repo;
    @PostConstruct
    //@Scheduled(cron = "* * * 1 * *")
    public void getData() throws IOException, InterruptedException {
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request= HttpRequest.newBuilder().uri(URI.create(UPDATE_URL)).build();
        HttpResponse response=client.send(request,HttpResponse.BodyHandlers.ofString());
        repo=parseCSV(response);
    }

    public ArrayList<record> getList()
    {
        return repo;
    }

    private ArrayList<record> parseCSV(HttpResponse response) throws IOException {
        ArrayList<record> allRecords=new ArrayList<>();
        StringReader csvReader= new StringReader((String) response.body());
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(csvReader);
        for (CSVRecord r: records) {
            record rec=new record(r);
            allRecords.add(rec);
        }
        return allRecords;
    }

    public ArrayList<record> searchbyparam(String query)
    {
        ArrayList<record> baselist=this.getList();
        ArrayList<record> finalList=new ArrayList<>();
        for(record r: baselist)
        {
            if(r.matchesString(query))
            {
                finalList.add(r);
            }
        }
        return finalList;
    }


}
