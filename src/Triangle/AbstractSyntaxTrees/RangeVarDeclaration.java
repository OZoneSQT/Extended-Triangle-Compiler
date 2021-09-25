package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RangeVarDeclaration extends Declaration {
    public RangeVarDeclaration(Identifier iAST_for, Expression e1AST, SourcePosition thePosition) {
        super(thePosition);
        I = iAST_for;
        E = e1AST;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitRangeVarDeclaration(this, o); }

    public Identifier I;
    public Expression E;
}
