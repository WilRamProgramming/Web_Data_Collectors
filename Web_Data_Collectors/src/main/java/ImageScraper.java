import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import com.opencsv.CSVWriter;

  public class ImageScraper {
    public static void main(String[] args) throws IOException, TesseractException {
      // Set up Tesseract OCR
      Tesseract tesseract = new Tesseract();
      tesseract.setDatapath("C:\\Users\\ATUM\\Desktop\\Tess4J\\tessdata");

      // Read the image
      File imageFile = new File("path/to/image.png");
      String imageText = tesseract.doOCR(imageFile);

      // Extract the data
      String[] lines = imageText.split("\\r?\\n");
      String invoiceNumber = lines[0];
      String invoiceDate = lines[1];
      String customerName = lines[2];
      String totalAmount = lines[3];

      // Store the data in a CSV file
      FileWriter writer = new FileWriter("path/to/output.csv");
      CSVWriter csvWriter = new CSVWriter(writer);
      csvWriter.writeNext(new String[] { "Invoice Number", "Invoice Date", "Customer Name", "Total Amount" });
      csvWriter.writeNext(new String[] { invoiceNumber, invoiceDate, customerName, totalAmount });
      csvWriter.close();
    }
  }

