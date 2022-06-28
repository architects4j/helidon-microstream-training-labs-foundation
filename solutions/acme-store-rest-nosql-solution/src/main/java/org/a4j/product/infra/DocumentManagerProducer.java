package org.a4j.product.infra;

import jakarta.nosql.document.DocumentCollectionManager;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

// TODO: Set this bean as ApplicationScope
@ApplicationScoped
class DocumentManagerProducer {

    // TODO: Use CDI to inject this bean
    // TODO: Obtain the `document` value configured in microprofile-config.properties. Use @ConfigProperty.
    @Inject
    @ConfigProperty(name = "document")
    private DocumentCollectionManager manager;

    @Produces
    public DocumentCollectionManager getManager() {
        return manager;
    }

    public void destroy(@Disposes DocumentCollectionManager manager) {
        manager.close();
    }
}
