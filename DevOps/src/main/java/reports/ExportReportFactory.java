package reports;

public class ExportReportFactory {
    public static ExportReport getExportReport(FileType fileType) {
        switch (fileType) {
            case PDF:
                return new PDFExportReport();
            case PNG:
                return new PNGExportReport();
            default:
                return null;
        }
    }
}
