package org.wso2.carbon.sample.user.operation.event.listener.internal;

import java.util.Dictionary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.sample.user.operation.event.listener.CustomUserOperationEventListener;
import org.wso2.carbon.user.core.listener.UserOperationEventListener;

/**
 * @scr.component name="sample.user.operation.event.listener.dscomponent" immediate=true
 */
public class CustomUserOperationEventListenerDSComponent {
    private static Log log = LogFactory.getLog(CustomUserOperationEventListenerDSComponent.class);

    public CustomUserOperationEventListenerDSComponent() {
    }

    protected void activate(ComponentContext context) {
        CustomUserOperationEventListener customUserOperationEventListener = new CustomUserOperationEventListener();
        context.getBundleContext().registerService(UserOperationEventListener.class.getName(), customUserOperationEventListener, (Dictionary)null);
        log.info("CustomUserOperationEventListenerDSComponent bundle activated successfully..");
    }

    protected void deactivate(ComponentContext context) {
        if (log.isDebugEnabled()) {
            log.debug("CustomUserOperationEventListenerDSComponent is deactivated ");
        }

    }
}