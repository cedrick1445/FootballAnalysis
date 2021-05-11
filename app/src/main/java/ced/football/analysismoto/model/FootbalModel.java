package ced.football.analysismoto.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FootbalModel {
    @SerializedName("teams")
    private List<Team> teams = null;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public static class Team {

        @SerializedName("idTeam")
        private String idTeam;

        @SerializedName("strTeam")
        private String strTeam;

        @SerializedName("strAlternate")
        private String strAlternate;

        @SerializedName("strTeamBadge")
        private String strTeamBadge;

        @SerializedName("intFormedYear")
        private String intFormedYear;

        @SerializedName("strStadium")
        private String strStadium;

        @SerializedName("strKeywords")
        private String strKeywords;

        @SerializedName("strStadiumThumb")
        private String strStadiumThumb;

        @SerializedName("strStadiumLocation")
        private String strStadiumLocation;

        @SerializedName("intStadiumCapacity")
        private String intStadiumCapacity;

        @SerializedName("strDescriptionEN")
        private String strDescriptionEN;

        @SerializedName("strTeamJersey")
        private String strTeamJersey;

        @SerializedName("strTeamLogo")
        private String strTeamLogo;

        @SerializedName("strTeamFanart2")
        private String strTeamFanart2;

        @SerializedName("strTeamBanner")
        private String strTeamBanner;

        public String getStrTeamBadge() {
            return strTeamBadge;
        }

        public void setStrTeamBadge(String strTeamBadge) {
            this.strTeamBadge = strTeamBadge;
        }

        public String getIdTeam() {
            return idTeam;
        }

        public void setIdTeam(String idTeam) {
            this.idTeam = idTeam;
        }

        public String getStrTeam() {
            return strTeam;
        }

        public void setStrTeam(String strTeam) {
            this.strTeam = strTeam;
        }

        public String getStrAlternate() {
            return strAlternate;
        }

        public void setStrAlternate(String strAlternate) {
            this.strAlternate = strAlternate;
        }

        public String getIntFormedYear() {
            return intFormedYear;
        }

        public void setIntFormedYear(String intFormedYear) {
            this.intFormedYear = intFormedYear;
        }

        public String getStrStadium() {
            return strStadium;
        }

        public void setStrStadium(String strStadium) {
            this.strStadium = strStadium;
        }

        public String getStrKeywords() {
            return strKeywords;
        }

        public void setStrKeywords(String strKeywords) {
            this.strKeywords = strKeywords;
        }

        public String getStrStadiumThumb() {
            return strStadiumThumb;
        }

        public void setStrStadiumThumb(String strStadiumThumb) {
            this.strStadiumThumb = strStadiumThumb;
        }

        public String getStrStadiumLocation() {
            return strStadiumLocation;
        }

        public void setStrStadiumLocation(String strStadiumLocation) {
            this.strStadiumLocation = strStadiumLocation;
        }

        public String getIntStadiumCapacity() {
            return intStadiumCapacity;
        }

        public void setIntStadiumCapacity(String intStadiumCapacity) {
            this.intStadiumCapacity = intStadiumCapacity;
        }


        public String getStrDescriptionEN() {
            return strDescriptionEN;
        }

        public void setStrDescriptionEN(String strDescriptionEN) {
            this.strDescriptionEN = strDescriptionEN;
        }

        public String getStrTeamJersey() {
            return strTeamJersey;
        }

        public void setStrTeamJersey(String strTeamJersey) {
            this.strTeamJersey = strTeamJersey;
        }

        public String getStrTeamLogo() {
            return strTeamLogo;
        }

        public void setStrTeamLogo(String strTeamLogo) {
            this.strTeamLogo = strTeamLogo;
        }

        public String getStrTeamFanart2() {
            return strTeamFanart2;
        }

        public void setStrTeamFanart2(String strTeamFanart2) {
            this.strTeamFanart2 = strTeamFanart2;
        }

        public String getStrTeamBanner() {
            return strTeamBanner;
        }

        public void setStrTeamBanner(String strTeamBanner) {
            this.strTeamBanner = strTeamBanner;
        }
    }
}
