package ru.gpb.slim.slimsprimg;

import com.atlassian.jira.rest.client.api.domain.Issue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JiraAction {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    MyJiraClient myJiraClient = new MyJiraClient(
            "user.name",
            "password",
            "http://jira.company.com");


    @Scheduled(initialDelay = 1000L, fixedDelay = 100_000)
    public void doSmth() {
        Issue issue = myJiraClient.getIssue("URRP-5825");
        myJiraClient.getAllComments(issue.getKey())
                .forEach(comment -> logger.info(comment.toString()));
    }
}
