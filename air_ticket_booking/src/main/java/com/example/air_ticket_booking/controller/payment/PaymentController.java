package com.example.air_ticket_booking.controller.payment;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import com.paypal.http.HttpResponse;
import com.paypal.orders.Order;
import com.paypal.orders.OrdersCaptureRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// ThanhVH
@RestController
public class PaymentController {

    @Value("${paypal.clientId}")
    private String clientId;

    @Value("${paypal.clientSecret}")
    private String clientSecret;

    @PostMapping("/paypal/capture")
    public ResponseEntity<String> capturePayPalOrder(@RequestBody String orderId) {
        try {
            // định nghĩa môi trường và thông tin xác thực để giao tiếp với PayPal = clientId, clientSecret
            PayPalEnvironment environment = new PayPalEnvironment.Sandbox(clientId, clientSecret);
            //sử dụng để gửi yêu cầu API đến PayPal.
            PayPalHttpClient client = new PayPalHttpClient(environment);

            //yêu cầu OrdersCaptureRequest với orderId của đơn hàng cần được capture.
            OrdersCaptureRequest request = new OrdersCaptureRequest(orderId);
            HttpResponse<Order> response = client.execute(request);
           //Lấy thông tin đơn hàng và trạng thái
            Order order = response.result();
            String status = order.status();

            //  trạng thái của đơn hàng PayPal

            return ResponseEntity.ok("\n" +
                    "Thanh toán thành công.\n" +
                    "Tình trạng đặt hàng: " + status);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("\n" +
                    "Lỗi thanh toán đơn đặt hàng PayPal.");
        }
    }
}