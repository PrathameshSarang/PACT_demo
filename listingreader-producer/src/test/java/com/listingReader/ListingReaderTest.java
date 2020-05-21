package com.listingReader;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import com.afourtech.application.ListingReaderApplication;
import com.afourtech.configuration.EnvironmentConfiguration;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

@RunWith(PactRunner.class)
@Provider("listingReader_provider")
@PactFolder("../pacts")
public class ListingReaderTest {

    //public final Target target = new HttpTarget(new URL("http://listingreader.staging.offerup.services")); // Out-of-the-box implementation of Target (for more information take a look at Test Target section)
    @ClassRule
    public static final DropwizardAppRule<EnvironmentConfiguration> RULE = new DropwizardAppRule<EnvironmentConfiguration>(ListingReaderApplication.class,"server-config.yml");

    @TestTarget
    public final Target target = new HttpTarget(8084);


    @State("The value of ListingReader API catagory 5")
    public void verifyListingReaderPactCatagory5() {

    }

    @State("The value of ListingReader API catagory 6")
    public void verifyListingReaderPactCatagory6() {

    }
}
