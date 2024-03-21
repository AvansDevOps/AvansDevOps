package reports;

import org.example.app.Sprint;

import java.time.LocalDate;

public class Report {
    private String reportName;
    private double version;
    private LocalDate date;
    private Sprint sprint;


    public Report( String reportName, double version, LocalDate date, Sprint sprint) {
        this.reportName = reportName;
        this.version = version;
        this.date = date;
        this.sprint = sprint;
    }

    public void generateReport(FileType type){
        System.out.println("Report is being generated");
        ExportReport exportReport = ExportReportFactory.getExportReport(type);
        exportReport.exportReport(this);

    }

    @Override
    public String toString() {
        return "Report{" +
                "reportName='" + reportName + '\'' +
                ", version=" + version +
                ", date=" + date +
                ", sprint=" + sprint +
                '}';
    }
}
