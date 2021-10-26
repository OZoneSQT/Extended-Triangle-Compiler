package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class VarExpressionDeclaration extends Declaration {
    public VarExpressionDeclaration(Identifier iAST, Expression eAST, SourcePosition thePosition) {
        super(thePosition);
        I = iAST;
        E = eAST;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitVarExpressionDeclaration(this, o);}
    public Identifier I;
    public Expression E;
    public TypeDenoter T;
}
