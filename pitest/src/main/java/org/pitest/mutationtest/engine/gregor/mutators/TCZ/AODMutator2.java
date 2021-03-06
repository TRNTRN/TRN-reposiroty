package org.pitest.mutationtest.engine.gregor.mutators.TCZ;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractInsnMutator;
import org.pitest.mutationtest.engine.gregor.InsnSubstitution;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.pitest.mutationtest.engine.gregor.ZeroOperandMutation;


import java.util.HashMap;
import java.util.Map;

public enum AODMutator2 implements MethodMutatorFactory {

  AOD_MUTATOR2;

  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new AODMethod2Visitor(this, methodInfo, context, methodVisitor);
  }

  @Override
  public String getGloballyUniqueId() {
    return this.getClass().getName();
  }

  @Override
  public String getName() {
    return name();
  }

}

class AODMethod2Visitor extends AbstractInsnMutator {

  AODMethod2Visitor(final MethodMutatorFactory factory,
                   final MethodInfo methodInfo, final MutationContext context,
                   final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();
  private static final String                            MESSAGE   = "Removed second operand (AOD)";

  static {

    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.NOP, "AOD Mutator: INT -  Removed the second operator"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.NOP, "AOD Mutator: FLOAT -  Removed the second operator"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.NOP, "AOD Mutator:  INT - Removed the second operator"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.NOP, "AOD Mutator: FLOAT - Removed the second operator"));
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.NOP, "AOD Mutator: INT - Removed the  second operator"));
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.NOP, "AOD Mutator: FLOAT - Removed the second operator"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.NOP, "AOD Mutator:INT -  Removed the  second operator"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.NOP, "AOD Mutator: FLOAT - Removed the second operator"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.NOP, "AOD Mutator: INT -  Removed the second operator"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.NOP, "AOD Mutator: FLOAT -  Removed the  operator"));

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}