package com.saritha.football.services.footballcrimelistservices.model.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result{
    public String postcode;
    public int quality;
    public int eastings;
    public int northings;
    public String country;
    public String nhs_ha;
    public double longitude;
    public double latitude;
    public String european_electoral_region;
    public String primary_care_trust;
    public String region;
    public String lsoa;
    public String msoa;
    public String incode;
    public String outcode;
    public String parliamentary_constituency;
    public String admin_district;
    public String parish;
    public Object admin_county;
    public String admin_ward;
    public Object ced;
    public String ccg;
    public String nuts;

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getEastings() {
        return eastings;
    }

    public void setEastings(int eastings) {
        this.eastings = eastings;
    }

    public int getNorthings() {
        return northings;
    }

    public void setNorthings(int northings) {
        this.northings = northings;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNhs_ha() {
        return nhs_ha;
    }

    public void setNhs_ha(String nhs_ha) {
        this.nhs_ha = nhs_ha;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getEuropean_electoral_region() {
        return european_electoral_region;
    }

    public void setEuropean_electoral_region(String european_electoral_region) {
        this.european_electoral_region = european_electoral_region;
    }

    public String getPrimary_care_trust() {
        return primary_care_trust;
    }

    public void setPrimary_care_trust(String primary_care_trust) {
        this.primary_care_trust = primary_care_trust;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLsoa() {
        return lsoa;
    }

    public void setLsoa(String lsoa) {
        this.lsoa = lsoa;
    }

    public String getMsoa() {
        return msoa;
    }

    public void setMsoa(String msoa) {
        this.msoa = msoa;
    }

    public String getIncode() {
        return incode;
    }

    public void setIncode(String incode) {
        this.incode = incode;
    }

    public String getOutcode() {
        return outcode;
    }

    public void setOutcode(String outcode) {
        this.outcode = outcode;
    }

    public String getParliamentary_constituency() {
        return parliamentary_constituency;
    }

    public void setParliamentary_constituency(String parliamentary_constituency) {
        this.parliamentary_constituency = parliamentary_constituency;
    }

    public String getAdmin_district() {
        return admin_district;
    }

    public void setAdmin_district(String admin_district) {
        this.admin_district = admin_district;
    }

    public String getParish() {
        return parish;
    }

    public void setParish(String parish) {
        this.parish = parish;
    }

    public Object getAdmin_county() {
        return admin_county;
    }

    public void setAdmin_county(Object admin_county) {
        this.admin_county = admin_county;
    }

    public String getAdmin_ward() {
        return admin_ward;
    }

    public void setAdmin_ward(String admin_ward) {
        this.admin_ward = admin_ward;
    }

    public Object getCed() {
        return ced;
    }

    public void setCed(Object ced) {
        this.ced = ced;
    }

    public String getCcg() {
        return ccg;
    }

    public void setCcg(String ccg) {
        this.ccg = ccg;
    }

    public String getNuts() {
        return nuts;
    }

    public void setNuts(String nuts) {
        this.nuts = nuts;
    }

    @Override
    public String toString() {
        return "Result{" +
                "postcode='" + postcode + '\'' +
                ", quality=" + quality +
                ", eastings=" + eastings +
                ", northings=" + northings +
                ", country='" + country + '\'' +
                ", nhs_ha='" + nhs_ha + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", european_electoral_region='" + european_electoral_region + '\'' +
                ", primary_care_trust='" + primary_care_trust + '\'' +
                ", region='" + region + '\'' +
                ", lsoa='" + lsoa + '\'' +
                ", msoa='" + msoa + '\'' +
                ", incode='" + incode + '\'' +
                ", outcode='" + outcode + '\'' +
                ", parliamentary_constituency='" + parliamentary_constituency + '\'' +
                ", admin_district='" + admin_district + '\'' +
                ", parish='" + parish + '\'' +
                ", admin_county=" + admin_county +
                ", admin_ward='" + admin_ward + '\'' +
                ", ced=" + ced +
                ", ccg='" + ccg + '\'' +
                ", nuts='" + nuts + '\'' +
                '}';
    }
}
