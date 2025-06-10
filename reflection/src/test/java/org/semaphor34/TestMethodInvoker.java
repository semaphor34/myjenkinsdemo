package org.semaphor34;


import org.junit.jupiter.api.Test;
import org.semaphor34.annotation.Mapper;
import org.semaphor34.core.MethodInvoker;
import org.semaphor34.core.MethodProvider;
import org.semaphor34.dummy.CommandSender;
import org.semaphor34.dummy.MethodCanvas;
import org.semaphor34.dummy.MethodExtension;

import java.lang.reflect.Method;

import static org.mockito.Mockito.*;

public class TestMethodInvoker {

    @Test
    void testFallbackMethodIsInvokedOnInstance() throws Exception {
        // arrange
        MethodExtension methodExtension = mock(MethodExtension.class);
        CommandSender commandSender = mock(CommandSender.class);

        // Mockito spy on the MethodProvider instance
        MethodProvider methodProvider = spy(MethodProvider.builder()
                .commandSender(commandSender)
                .plugin(methodExtension)
                .build()
        );

        Method method = MethodProvider.class.getDeclaredMethod("methodForCanvas", MethodCanvas.class);
        Mapper mapper = method.getParameters()[0].getAnnotation(Mapper.class);

        MethodInvoker<MethodExtension> methodInvoker = new MethodInvoker<>();

        // act
        methodInvoker.invoke(mapper, "fancyMethodCanvas", methodProvider);

        // Assert: the fallback method with HIGH priority on the spy should be called
        verify(methodProvider, times(1)).methodForCanvasFallback3("fancyMethodCanvas");
        verify(methodProvider, never()).methodForCanvasFallback1("fancyMethodCanvas");
        verify(methodProvider, never()).methodForCanvasFallback2("fancyMethodCanvas");
    }
}
