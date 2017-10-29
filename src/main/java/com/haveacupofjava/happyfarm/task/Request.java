package com.haveacupofjava.happyfarm.task;

import java.util.ArrayList;
import java.util.List;

public class Request {

    private RequestCategory category;
    private String tool;
    private Class field;

    private static List<RequestParsingRule> requestParsingRuleList =
            new ArrayList<RequestParsingRule>();

    /**
     * Constructor for the class {@code Request}
     * @param command The command string of this request
     * @throws RequestParsingException if the request is not parsable
     */
    public Request(String command) throws RequestParsingException {
        for (RequestParsingRule requestParsingRule : requestParsingRuleList) {
            if (requestParsingRule.getCommandString().equals(command)) {
                category = requestParsingRule.getRequestCategory();
                tool = requestParsingRule.getTool();
                field = requestParsingRule.getField();

                return;
            }
        }

        throw new RequestParsingException("The request \"" + command +
                "\" is not parsable. Please add your customized RequestParsingRule by " +
                "calling the method Request.addParsingRule() first.");
    }

    public RequestCategory getCategory() {
        return category;
    }

    public String getTool() {
        return tool;
    }

    public Class getField() {
        return field;
    }

    /**
     * Adds a new RequestParsingRule into requestParsingRuleList
     * @param requestParsingRule The rule to be added
     * @throws DuplicateRequestParsingRuleException if the rule already exists
     */
    public static void addRequestParsingRule(RequestParsingRule requestParsingRule)
            throws DuplicateRequestParsingRuleException {
        for (RequestParsingRule rule : requestParsingRuleList) {
            if (rule.getCommandString().equals(requestParsingRule.getCommandString())) {
                throw new DuplicateRequestParsingRuleException("The RequestParsingRule " +
                        rule.toString() + " already exists.");
            }
        }

        requestParsingRuleList.add(requestParsingRule);
    }

}
