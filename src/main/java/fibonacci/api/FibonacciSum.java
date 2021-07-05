package fibonacci.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FibonacciSum {
    private String memberCount;
    private String sequence;
    private String total;
    private String invalidInput;

    public FibonacciSum(String invalidInput) {
        this.invalidInput = invalidInput;
    }

    @JsonProperty
    public String getInvalidInput() {
        if(invalidInput != null ) {
            return invalidInput;
        } else {
            return "false";
        }
    }

    public FibonacciSum() {
        // Jackson deserialization
    }

    public FibonacciSum(String memberCount, String sequence, String total) {
        this.memberCount = memberCount;
        this.sequence = sequence;
        this.total = total;
    }

    @JsonProperty
    public String getMemberCount() {
        if(memberCount != null ) {
            return memberCount;
        } else {
            return "No Response";
        }
    }

    @JsonProperty
    public String getSequence() {
        if(sequence != null ) {
            return sequence;
        } else {
            return "No Response";
        }
    }

    @JsonProperty
    public String getTotal() {
        if(total != null ) {
            return total;
        } else {
            return "No Response";
        }
    }

}
