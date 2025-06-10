package org.semaphor34.core;

import org.semaphor34.dummy.CommandSender;
import org.semaphor34.dummy.MethodExtension;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@AllArgsConstructor
public abstract class AnnotatedCommandExecutor<E extends MethodExtension> {
    protected final CommandSender commandSender;
    protected final  E plugin;
}