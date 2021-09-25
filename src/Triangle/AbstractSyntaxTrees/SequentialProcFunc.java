package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class SequentialProcFunc extends Declaration {
    public SequentialProcFunc(Declaration pfd1AST, Declaration pfd2AST, SourcePosition thePosition) {
        super(thePosition);
        PFD1 = pfd1AST;
        PFD2 = pfd2AST;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitSequentialProcFunc(this, o); }

    public Declaration PFD1;
    public Declaration PFD2;

}
