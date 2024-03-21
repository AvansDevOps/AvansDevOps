package reports;

public class PNGExportReport implements ExportReport{
    private Report report;
    @Override
    public void exportReport(Report report) {
        this.report = report;
        System.out.println("Exporting report as PNG");
        System.out.println(report.toString());

    }

    @Override
    public String toString() {
        return "PNGExportReport{" +
                "report=" + report +
                '}';
    }
}