package Triangle.AbstractSyntaxTrees;

public interface RecursiveVisitor extends Visitor{

    Object visitRecursiveProcRec1(ProcDeclaration ast, Object o);
    Object visitRecursiveProcRec2(ProcDeclaration ast, Object o);
    Object visitRecursiveFuncRec1(FuncDeclaration ast, Object o);
    Object visitRecursiveFuncRec2(FuncDeclaration ast, Object o);
}
