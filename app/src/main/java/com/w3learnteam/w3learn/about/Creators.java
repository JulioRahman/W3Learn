package com.w3learnteam.w3learn.about;

public class Creators {
    String creatorname;
    String creatorjob;
    Integer creatorpic;

    public Creators() {
    }

    public Creators(String creatorname, String creatorjob, Integer creatorpic) {
        this.creatorname = creatorname;
        this.creatorjob = creatorjob;
        this.creatorpic = creatorpic;
    }

    public String getCreatorname() {
        return creatorname;
    }

    public void setCreatorname(String creatorname) {
        this.creatorname = creatorname;
    }

    public String getCreatorjob() {
        return creatorjob;
    }

    public void setCreatorjob(String creatorjob) {
        this.creatorjob = creatorjob;
    }

    public Integer getCreatorpic() {
        return creatorpic;
    }

    public void setCreatorpic(Integer creatorpic) {
        this.creatorpic = creatorpic;
    }
}
