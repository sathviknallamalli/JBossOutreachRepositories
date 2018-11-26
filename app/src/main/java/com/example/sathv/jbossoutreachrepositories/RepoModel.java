package com.example.sathv.jbossoutreachrepositories;

/**
 * Created by sathv on 11/24/2018.
 */

public class RepoModel {
    String reponame, codelang, description, lastupdate, contributorurl, forkcount, starcount;

    public RepoModel(String reponame, String codelang, String description, String lastupdate, String created, String forkcount, String starcount) {
        this.reponame = reponame;
        this.codelang = codelang;
        this.description = description;
        this.lastupdate = lastupdate;
        this.contributorurl = created;
        this.forkcount = forkcount;
        this.starcount = starcount;
    }

    public String getForkcount() {
        return forkcount;
    }

    public void setForkcount(String forkcount) {
        this.forkcount = forkcount;
    }

    public String getStarcount() {
        return starcount;
    }

    public void setStarcount(String starcount) {
        this.starcount = starcount;
    }

    public String getContributorurl() {
        return contributorurl;
    }

    public void setContributorurl(String contributorurl) {
        this.contributorurl = contributorurl;
    }

    public String getReponame() {
        return reponame;
    }

    public void setReponame(String reponame) {
        this.reponame = reponame;
    }

    public String getCodelang() {
        return codelang;
    }

    public void setCodelang(String codelang) {
        this.codelang = codelang;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }
}
