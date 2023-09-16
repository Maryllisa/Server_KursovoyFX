package data;

public class Report {
    private int id_report;
    private int col_passes;
    private float rating;
    private float coefficent;
    private float perconal_schjlarsip;

    public Report(int id_report, int col_passes, float rating, float coefficent, float perconal_schjlarsip) {
        this.id_report = id_report;
        this.col_passes = col_passes;
        this.rating = rating;
        this.coefficent = coefficent;
        this.perconal_schjlarsip = perconal_schjlarsip;
    }

    public Report() {

    }

    public int getId_report() {
        return id_report;
    }

    public void setId_report(int id_report) {
        this.id_report = id_report;
    }

    public int getCol_passes() {
        return col_passes;
    }

    public void setCol_passes(int col_passes) {
        this.col_passes = col_passes;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }



    public float getCoefficent() {
        return coefficent;
    }

    public void setCoefficent(float coefficent) {
        this.coefficent = coefficent;
    }

    public float getPerconal_schjlarsip() {
        return perconal_schjlarsip;
    }

    public void setPerconal_schjlarsip(float perconal_schjlarsip) {
        this.perconal_schjlarsip = perconal_schjlarsip;
    }
}
