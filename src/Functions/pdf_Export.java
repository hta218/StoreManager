/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import DatabaseAccessObject_DAO.ChiTietHoaDonDAO;
import DatabaseAccessObject_DAO.HoaDonDAO;
import DatabaseAccessObject_DAO.KhachHangDAO;
import DatabaseAccessObject_DAO.NhanVienDAO;
import Object_BusinessLogic.ChiTietHoaDon;
import Object_BusinessLogic.HoaDon;
import Object_BusinessLogic.KhachHang;
import Object_BusinessLogic.NhanVien;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huynh
 */
public class pdf_Export {

    private String shopName = "My Shop";
    private String address = "#1 Dai Co Viet Street, Bach Khoa Ward, Hai Ba Trung"
            + " District, Hanoi";
    private String phoneNumb = "01687 176 583";
    private String email = "huynhtuananh21895@gmail.com";
    private String web = "www.myshop.com.vn";

    private Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);
    private Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    private Font italicFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.ITALIC);

    public void billExportToPDF(Integer soHoaDon, String path) {
        try {
            HoaDon hoaDon = new HoaDonDAO().getHoaDon(soHoaDon);
            KhachHang kh = new KhachHangDAO().getKHByID(hoaDon.getMaKhachHang());
            NhanVien nv = new NhanVienDAO().getNVByID(hoaDon.getMaNhanVien());
            //  create new pdf document
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(path));
            doc.open();
            //  pdf content

            // create header
            createHeader(doc, soHoaDon);

            // customer info
            Paragraph paragraph = new Paragraph();
            addEmptyLine(paragraph, 2);
            
            Paragraph p = new Paragraph();
            p.add(new Phrase("INVOICE", titleFont));
            p.setAlignment(Element.ALIGN_CENTER);
            addEmptyLine(p, 1);
            paragraph.add(p);
            
            paragraph.add(new Paragraph("Customer Name: " + kh.getHoTenKH(), smallFont));
            paragraph.add(new Paragraph("Address: " + kh.getDiachi(), smallFont));
            paragraph.add(new Paragraph("Phone Number: " + kh.getSdt(), smallFont));
            addEmptyLine(paragraph, 1);
            doc.add(paragraph);

            // product infor
            createProductTable(doc, soHoaDon);

            // bill footer
            createFooter(doc, hoaDon, nv, kh);

            doc.close();
        } catch (DocumentException ex) {
            Logger.getLogger(pdf_Export.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pdf_Export.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addEmptyLine(Paragraph paragraph, Integer numb) {
        for (int i = 0; i < numb; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public void createHeader(Document doc, Integer soHoaDon) {
        try {
            PdfPTable table = new PdfPTable(new float[]{80, 20});
            table.setWidthPercentage(100);

            LinkedHashMap<String, Font> lines = new LinkedHashMap<>();
            lines.put("Shop Name: " + shopName, titleFont);
            lines.put("Address: " + address, smallFont);
            lines.put("Phone Number: " + phoneNumb, smallFont);
            lines.put("Website: " + web, smallFont);
            lines.put("Email: " + email, smallFont);

            // left cell with shop's infor
            PdfPCell leftCell = new PdfPCell();
            leftCell.setPaddingTop(-7);
            leftCell.setPaddingRight(35);
            Set<String> singleLine = lines.keySet();
            // this below loop to create a line with text, and set it's font
            for (String line : singleLine) {
                leftCell.addElement(new Phrase(line, lines.get(line)));
            }
            leftCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            leftCell.setBorder(PdfPCell.NO_BORDER);
            table.addCell(leftCell);

            // right cell with bill's time
            String time = new HoaDonDAO().getHoaDon(soHoaDon).getNgayLapHoaDon().toString();
            PdfPCell rightCell = new PdfPCell();
            rightCell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            rightCell.addElement(new Phrase("Date: " + time +
                    "\nNo.: " + soHoaDon, smallFont));
            
            rightCell.setBorder(PdfPCell.NO_BORDER);
            table.addCell(rightCell);

            doc.add(table);
        } catch (DocumentException ex) {
            Logger.getLogger(pdf_Export.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new pdf_Export().billExportToPDF(12, "F://bill.pdf");
    }

    private void createProductTable(Document doc, Integer soHoaDon) {
        try {
            PdfPTable table = new PdfPTable(new float[]{10, 35, 15, 20, 20});
            table.setWidthPercentage(100);
            String[] colName = {"No.", "Product Name", "Quantity", "Price (VND)", "Amount"};
            // table header
            for (int i = 0; i < colName.length; i++) {
                PdfPCell cell = new PdfPCell(new Phrase(colName[i], subFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            List<ChiTietHoaDon> listCTHD = new ChiTietHoaDonDAO().getListChiTietHoaDon(soHoaDon);
            Integer productAmount = listCTHD.size();
            for (Integer i = 0; i < productAmount; i++) {
                String[] rowValue = getRowValue(i + 1, listCTHD);
                for (int j = 0; j < rowValue.length; j++) {
                    PdfPCell cell = new PdfPCell(new Phrase(rowValue[j], smallFont));
                    if (j == 1) {
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    } else {
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    }
                    table.addCell(cell);
                }
            }

            // add some blank rows
            for (Integer i = productAmount + 1; i < 11; i++) {
                for (int j = 0; j < 5; j++) {
                    PdfPCell cell;
                    if (j == 0) {
                        cell = new PdfPCell(new Phrase(i.toString(), smallFont));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    } else {
                        cell = new PdfPCell(new Phrase(" "));
                    }
                    table.addCell(cell);
                }
            }
            
            doc.add(table);
            Paragraph p = new Paragraph();
            addEmptyLine(p, 1);
            doc.add(p);
        } catch (DocumentException ex) {
            Logger.getLogger(pdf_Export.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String[] getRowValue(Integer i, List<ChiTietHoaDon> listCTHD) {
        String[] rowValue = new String[5];
        rowValue[0] = (i).toString();
        i = i - 1;
        rowValue[1] = listCTHD.get(i).getTenSanPham();
        rowValue[2] = listCTHD.get(i).getSoLuong().toString();
        rowValue[3] = new DecimalFormat("#,###").
                format(Integer.parseInt(listCTHD.get(i).getDonGiaSanPham()));
        rowValue[4] = new DecimalFormat("#,###").format(listCTHD.get(i).getThanhTien());
        return rowValue;
    }

    private void createFooter(Document doc, HoaDon hoaDon, NhanVien nv, KhachHang kh) {
        try {
            String total = new DecimalFormat("#,###").format(hoaDon.getTongTien());
            Paragraph paragraph = new Paragraph();
            paragraph.add(new Phrase("Total: " + total + " (VND)", smallFont));
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            addEmptyLine(paragraph, 3);
            doc.add(paragraph);

            PdfPTable table = new PdfPTable(2);
            PdfPCell cell = new PdfPCell(new Phrase("Sale Staff", subFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorder(0);
            table.addCell(cell);
            cell.setPhrase(new Phrase("Customer", subFont));
            table.addCell(cell);
            // add 3 blank row
            for (Integer i = 0; i < 10; i++) {
                cell.setPhrase(new Phrase(" "));
                table.addCell(cell);
            }
            cell.setPhrase(new Phrase(nv.getHoTenNhanVien(), smallFont));
            table.addCell(cell);
            cell.setPhrase(new Phrase(kh.getHoTenKH(), smallFont));
            table.addCell(cell);
            doc.add(table);

            paragraph = new Paragraph();
            addEmptyLine(paragraph, 5);
            paragraph.add(new Phrase("Bill generated by: " + nv.getHoTenNhanVien()
                    + " - " + nv.getMaNhanVien() + ", " + new Date(), italicFont));
            doc.add(paragraph);
        } catch (DocumentException ex) {
            Logger.getLogger(pdf_Export.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
