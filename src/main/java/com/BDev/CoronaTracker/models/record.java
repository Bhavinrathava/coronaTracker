package com.BDev.CoronaTracker.models;

import org.apache.commons.csv.CSVRecord;

import java.net.http.HttpResponse;

public class record {
     private String FIPS,Admin2,Province_State,Country_Region,Last_Update;
    private float Lat,Long_;
    private Long Confirmed,Deaths,Recovered,Active;
    private String Combined_Key;
    private float Incidence_Rate,CaseToFatality_Ratio;

    public String getProvince_State()
    {
        return this.Province_State;
    }

    public String getFIPS() {
        return FIPS;
    }

    public String getAdmin2() {
        return Admin2;
    }

    public String getCountry_Region() {
        return Country_Region;
    }

    public String getLast_Update() {
        return Last_Update;
    }

    public float getLat() {
        return Lat;
    }

    public float getLong_() {
        return Long_;
    }

    public Long getConfirmed() {
        return Confirmed;
    }

    public Long getDeaths() {
        return Deaths;
    }

    public Long getRecovered() {
        return Recovered;
    }

    public Long getActive() {
        return Active;
    }

    public String getCombined_Key() {
        return Combined_Key;
    }

    public float getIncidence_Rate() {
        return Incidence_Rate;
    }

    public float getCaseToFatality_Ratio() {
        return CaseToFatality_Ratio;
    }

    public record(CSVRecord rec)
    {
        this.FIPS=rec.get(0).isEmpty()?"":rec.get(0);
        this.Admin2=rec.get(1).isEmpty()?"":rec.get(1);
        this.Province_State=rec.get(2).isEmpty()?"":rec.get(2);
        this.Country_Region=rec.get(3).isEmpty()?"":rec.get(3);
        this.Last_Update=rec.get(4).isEmpty()?"":rec.get(4);
        this.Lat=Float.parseFloat(rec.get(5).equals("")?"0":rec.get(5));
        this.Long_=Float.parseFloat(rec.get(6).equals("")?"0":rec.get(6));
        this.Confirmed=Long.parseLong(rec.get(7).equals("")?"0":rec.get(7));
        this.Deaths=Long.parseLong(rec.get(8).equals("")?"0":rec.get(8));
        this.Recovered=Long.parseLong(rec.get(9).equals("")?"0":rec.get(9));
        this.Active=Long.parseLong(rec.get(10).equals("")?"0":rec.get(10));
        this.Combined_Key=rec.get(11).isEmpty()?"":rec.get(11);
        this.Incidence_Rate=Float.parseFloat(rec.get(12).equals("")?"0":rec.get(12));
        this.CaseToFatality_Ratio=Float.parseFloat(rec.get(13).equals("")?"0":rec.get(13));
    }
}
