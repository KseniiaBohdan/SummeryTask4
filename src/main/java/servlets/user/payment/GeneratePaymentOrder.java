package servlets.user.payment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import data.dto.PaymentDto;
import data.entity.Payment;
import service.impl.PaymentServiceImpl;
import service.impl.UserServiceImpl;
import servlets.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GeneratePaymentOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long paymentId = Long.valueOf(req.getParameter("paymentModelG"));
        Payment payment = new PaymentServiceImpl().getById(paymentId);
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setPayment(payment);
        paymentDto.setSenderName(new UserServiceImpl().getByCardNumber(payment.getCardNumberSender()).getName());
        paymentDto.setReceiverName(new UserServiceImpl().getByCardNumber(payment.getCardNumberReceiver()).getName());
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("payment_order_" + payment.getId() + ".pdf"));
            document.open();
            document.add(new Paragraph(" __________________________________________________\n"));
            document.add(new Paragraph("| Payment order #" + payment.getId() + "\n"));
            document.add(new Paragraph("|__________________________________________________\n"));
            document.add(new Paragraph("***************************************************\n"));
            document.add(new Paragraph(" __________________________________________________\n"));
            document.add(new Paragraph("| From: " + paymentDto.getSenderName()));
            document.add(new Paragraph("| Card: " + paymentDto.getPayment().getCardNumberSender() + "\n"));
            document.add(new Paragraph("|__________________________________________________\n"));
            document.add(new Paragraph("***************************************************\n"));
            document.add(new Paragraph(" __________________________________________________\n"));
            document.add(new Paragraph("| To: " + paymentDto.getReceiverName()));
            document.add(new Paragraph("| Card: " + paymentDto.getPayment().getCardNumberReceiver() + "\n"));
            document.add(new Paragraph("|__________________________________________________\n"));
            document.add(new Paragraph("***************************************************\n"));
            document.add(new Paragraph(" __________________________________________________\n"));
            document.add(new Paragraph("| Sum: " + payment.getSum()+"\n"));
            document.add(new Paragraph("| Title: " + payment.getTitle()+"\n"));
            document.add(new Paragraph("|__________________________________________________\n"));
            document.add(new Paragraph("***************************************************\n"));
            document.add(new Paragraph(" __________________________________________________\n"));
            document.add(new Paragraph("| Date:" + paymentDto.getPayment().getDate()));
            document.add(new Paragraph("|__________________________________________________\n"));
            document.close();
            writer.flush();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(PageConstant.USER_PAYMENTS_HISTORY_SERVLET);
    }

}
