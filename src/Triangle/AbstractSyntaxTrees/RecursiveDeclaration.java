package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RecursiveDeclaration extends Declaration {
    public RecursiveDeclaration(Declaration pfAST, SourcePosition thePosition) {
        super(thePosition);
        PF = pfAST;

    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitRecursiveDeclaration(this, o); }

    public Declaration PF;
}
