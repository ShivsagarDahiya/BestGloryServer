package com.satna.service;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import com.satna.domain.PaymentMethod;
import com.satna.model.Order;
import com.satna.model.PaymentOrder;
import com.satna.model.User;
import com.satna.response.PaymentLinkResponse;
import com.stripe.exception.StripeException;

import java.util.List;
import java.util.Set;


public interface PaymentService {

    PaymentOrder createOrder(User user,
                             Set<Order> orders);

    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    PaymentOrder getPaymentOrderByPaymentId(String paymentId) throws Exception;

    Boolean ProceedPaymentOrder (PaymentOrder paymentOrder,
                                 String paymentId, String paymentLinkId) throws RazorpayException;

    PaymentLink createRazorpayPaymentLink(User user,
                                          Long Amount,
                                          Long orderId) throws RazorpayException;

    String createStripePaymentLink(User user, Long Amount,
                                            Long orderId) throws StripeException;
}
