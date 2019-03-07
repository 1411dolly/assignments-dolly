package demo.service

import demo.domain.Order
import spock.lang.Specification

class EmailServiceSpec extends Specification {

    def "Testing sendEmail() example"() {

        given: "Creating EmailService"

        EmailService emailService=new EmailService();

        and: "Create Order and Initializing order"

        Order order = new Order()
        order.setItemName("Product ONE").setQuantity(1).setPrice(100)

        when:

        emailService.sendEmail(order)

        then:
        thrown(RuntimeException)

    }

    def "Testing sendEmail(arg1, arg2) example"() {

        given: "Creating EmailService, Order instance"

        EmailService emailService=new EmailService();
        Order order = new Order();

        and: "Initializing order"

        order.setItemName("Product TWO").setQuantity(2).setPrice(100)

        and: "Storing Result"

        boolean response;

        when: "Calling sendEmail() with parameters"
        String string="TEST"
        response = emailService.sendEmail(order,string)

        then:

        response == result

        where:
        sno | result
        1   | true


    }

}