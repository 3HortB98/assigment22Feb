package com.example.pwnedcheckerapi;

import java.util.List;

public class APIResponse {

    public class DomainInput{
        private String domain;
        public DomainInput(String domain){
            this.domain = domain;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }
    }

    public class Resquest{
         private String name;
        private String title;
        private String domain;
        private String breachDate;
        private String  addedDate;
        private String modifiedDate;
        private Integer pwnCount;
        private String description;
        private String logoPath;
        private List dataClasses;
        private Boolean isVerified;
        private Boolean isFabricated;
        private Boolean isSensitive;
        private Boolean isRetired;
        private Boolean isSpamList;

        public Resquest(String name, String title, String domain, String breachDate, String addedDate, String modifiedDate, Integer pwnCount, String description, String logoPath, List<String> dataClasses, Boolean isVerified, Boolean isFabricated, Boolean isSensitive, Boolean isRetired, Boolean isSpamList) {

            this.name = name;
            this.title = title;
            this.domain = domain;
            this.breachDate = breachDate;
            this.addedDate = addedDate;
            this.modifiedDate = modifiedDate;
            this.pwnCount = pwnCount;
            this.description = description;
            this.logoPath = logoPath;
            this.dataClasses = dataClasses;
            this.isVerified = isVerified;
            this.isFabricated = isFabricated;
            this.isSensitive = isSensitive;
            this.isRetired = isRetired;
            this.isSpamList = isSpamList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getBreachDate() {
            return breachDate;
        }

        public void setBreachDate(String breachDate) {
            this.breachDate = breachDate;
        }

        public String getAddedDate() {
            return addedDate;
        }

        public void setAddedDate(String addedDate) {
            this.addedDate = addedDate;
        }

        public String getModifiedDate() {
            return modifiedDate;
        }

        public void setModifiedDate(String modifiedDate) {
            this.modifiedDate = modifiedDate;
        }

        public Integer getPwnCount() {
            return pwnCount;
        }

        public void setPwnCount(Integer pwnCount) {
            this.pwnCount = pwnCount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLogoPath() {
            return logoPath;
        }

        public void setLogoPath(String logoPath) {
            this.logoPath = logoPath;
        }

        public List getDataClasses() {
            return dataClasses;
        }

        public void setDataClasses(List dataClasses) {
            this.dataClasses = dataClasses;
        }

        public Boolean getVerified() {
            return isVerified;
        }

        public void setVerified(Boolean verified) {
            isVerified = verified;
        }

        public Boolean getFabricated() {
            return isFabricated;
        }

        public void setFabricated(Boolean fabricated) {
            isFabricated = fabricated;
        }

        public Boolean getSensitive() {
            return isSensitive;
        }

        public void setSensitive(Boolean sensitive) {
            isSensitive = sensitive;
        }

        public Boolean getRetired() {
            return isRetired;
        }

        public void setRetired(Boolean retired) {
            isRetired = retired;
        }

        public Boolean getSpamList() {
            return isSpamList;
        }

        public void setSpamList(Boolean spamList) {
            isSpamList = spamList;
        }

        @Override
        public String toString() {
            return
                    "name='" + name + '\'' +
                    ", title='" + title + '\'' +
                    ", domain='" + domain + '\'' +
                    ", breachDate='" + breachDate + '\'' +
                    ", addedDate='" + addedDate + '\'' +
                    ", modifiedDate='" + modifiedDate + '\'' +
                    ", pwnCount=" + pwnCount +
                    ", description='" + description + '\'' +
                    ", logoPath='" + logoPath + '\'' +
                    ", dataClasses=" + dataClasses +
                    ", isVerified=" + isVerified +
                    ", isFabricated=" + isFabricated +
                    ", isSensitive=" + isSensitive +
                    ", isRetired=" + isRetired +
                    ", isSpamList=" + isSpamList;
        }
    }


}


