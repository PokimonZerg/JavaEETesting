package ru.otus.qa.automation.arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Arquillian.class)
public class ArquillianWebTest
{
    @Deployment
    public static WebArchive createDeployment()
    {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage("ru.otus.qa.automation.arquillian")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource(new File("src/main/webapp", "WEB-INF/jboss-web.xml"));
    }

    @Test
    @RunAsClient
    public void testRestApi()
    {
        when()
                .get("/number")
        .then()
                .statusCode(200)
                .body(equalTo("42"))
                .log().all();
    }
}
