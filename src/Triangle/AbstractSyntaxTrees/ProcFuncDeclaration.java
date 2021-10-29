package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ProcFuncDeclaration extends Declaration{

    public ProcFuncDeclaration (SourcePosition thePosition) {
        super (thePosition);
        duplicated = false;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return null;
    }

    public Object visitRecursivePass1(RecursiveVisitor v, Object o) {
        return null;
    };

    public Object visitRecursivePass2(RecursiveVisitor v, Object o) {
        return null;
    };
}
