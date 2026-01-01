package Models;
import enums.*;

public class ConditionReport {
    //attributes
    private int reportID;
    private int rentalID;
    private String scratches;
    private String interiorDamage;
    private String tireCondition;
    private String notes;
    private ReportStage stage;

    //constructor
    public ConditionReport(){};
    public ConditionReport(int reportID, int rentalID, String scratches, String interiorDamage, String tireCondition, String notes, ReportStage stage) {
        this.reportID = reportID;
        this.rentalID = rentalID;
        this.scratches = scratches;
        this.interiorDamage = interiorDamage;
        this.tireCondition = tireCondition;
        this.notes = notes;
        this.stage=stage;
    }
    //Getter n Setter
    public int getReportID() {
        return reportID;
    }
    public void setReportID(int reportID) {
        this.reportID = reportID;
    }
    public int getRentalID() {
        return rentalID;
    }
    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }
    public String getScratches() {
        return scratches;
    }
    public void setScratches(String scratches) {
        this.scratches = scratches;
    }
    public String getInteriorDamage() {
        return interiorDamage;
    }
    public void setInteriorDamage(String interiorDamage) {
        this.interiorDamage = interiorDamage;
    }
    public String getTireCondition() {
        return tireCondition;
    }
    public void setTireCondition(String tireCondition) {
        this.tireCondition = tireCondition;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public ReportStage getStage() {
        return stage;
    }
    public void setStage(ReportStage stage) {
        this.stage = stage;
    }
}
