package net.breezeware.order.enumeration;

/**
 * The OrderStatus enum represents the possible statuses of an order.
 */
public enum OrderStatus {

    /**
     * The order is currently in the user's cart.
     */
    IN_CART,

    /**
     * The order has been cancelled by the user.
     */
    ORDER_CANCELLED,

    /**
     * The order has been placed but not yet processed.
     */
    ORDER_PLACED,

    /**
     * The order has been received and is awaiting further processing.
     */
    RECEIVED_ORDER,

    /**
     * The order is prepared and waiting for delivery.
     */
    ORDER_PREPARED_WAITING_FOR_DELIVERY,

    /**
     * The order is pending delivery.
     */
    PENDING_DELIVERY,

    /**
     * The order has been successfully delivered to the user.
     */
    ORDER_DELIVERED
}
