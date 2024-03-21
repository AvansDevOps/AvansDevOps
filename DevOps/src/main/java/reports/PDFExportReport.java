package reports;

public class PDFExportReport implements ExportReport{
    private Report report;
    @Override
    public void exportReport(Report report) {
        this.report = report;
        System.out.println("Exporting report as PDF ");
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "PDFExportReport{" +
                "report=" + report +
                '}';
    }
}
