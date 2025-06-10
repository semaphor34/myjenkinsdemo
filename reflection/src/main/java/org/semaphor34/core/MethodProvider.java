package org.semaphor34.core;

import org.semaphor34.annotation.Argument;
import org.semaphor34.annotation.ArgumentFallback;
import org.semaphor34.annotation.Mapper;
import org.semaphor34.dummy.MethodCanvas;
import org.semaphor34.dummy.MethodExtension;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class MethodProvider extends AnnotatedCommandExecutor<MethodExtension> {
    @Argument
    public void methodForCanvas(@Mapper("methodCanvasMapper") MethodCanvas methodCanvas) {
        System.out.println("methodForCanvas has been invoked.");
    }

    @ArgumentFallback(value= {"methodCanvasMapper"}, priority = ArgumentFallback.Priority.NORMAL)
    public void methodForCanvasFallback1(String methodCanvas) {
        System.out.println("methodForCanvasFallback1 has been invoked. " + methodCanvas);
    }

    @ArgumentFallback(value= {"methodCanvasMapper"}, priority = ArgumentFallback.Priority.LOW)
    public void methodForCanvasFallback2(String methodCanvas) {
        System.out.println("methodForCanvasFallback2 has been invoked. " + methodCanvas);
    }

    @ArgumentFallback(value= {"methodCanvasMapper"}, priority = ArgumentFallback.Priority.HIGH)
    public void methodForCanvasFallback3(String methodCanvas) {
        System.out.println("methodForCanvasFallback3 has been invoked for " + methodCanvas);
    }

}