package fibonacci.resources;

import com.codahale.metrics.annotation.Timed;
import fibonacci.api.FibonacciSum;
import fibonacci.core.FibonacciGenerator;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Path("/fibonacci")
@Produces(MediaType.APPLICATION_JSON)
public class FibonacciSumResource {
    private final String template;
    private final String defaultNumber;
    private final AtomicLong counter;

    public FibonacciSumResource(String template, String defaultNumber) {
        this.template = template;
        this.defaultNumber = defaultNumber;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public FibonacciSum sumGenerator(@QueryParam("number") String number) {
        int fibonacciTotal;
        int memberCount;
        List<Integer> sequence;
        String invalidInput;
        FibonacciGenerator generatorObj;
        if(StringUtils.isEmpty(number)) {
            generatorObj = new FibonacciGenerator(defaultNumber);
        } else {
            generatorObj = new FibonacciGenerator(number);
        }
        memberCount = generatorObj.getNumber();
        fibonacciTotal = generatorObj.getTotal();
        sequence = generatorObj.getSequence();
        invalidInput = generatorObj.getInvalidInput();
        if(invalidInput.contains("Invalid Input")) {
            final String invalidInputStr = invalidInput;
            return new FibonacciSum(invalidInputStr);
        } else {
            final String memberCountStr = String.valueOf(memberCount);
            final String totalStr = String.valueOf(fibonacciTotal);
            final String sequenceStr = String.valueOf(sequence);
            return new FibonacciSum(memberCountStr, sequenceStr, totalStr );
        }
    }
}