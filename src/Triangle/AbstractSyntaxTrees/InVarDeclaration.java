package Triangle.AbstractSyntaxTrees;

import Triangle.AbstractSyntaxTrees.Declaration;
import Triangle.AbstractSyntaxTrees.Expression;
import Triangle.AbstractSyntaxTrees.Identifier;
import Triangle.AbstractSyntaxTrees.Visitor;
import Triangle.SyntacticAnalyzer.SourcePosition;

public class InVarDeclaration extends Declaration {
    public InVarDeclaration(Identifier iAST_for, Expression e1AST_in, SourcePosition thePosition) {
        super(thePosition);
        I = iAST_for;
        E = e1AST_in;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitInVarDeclaration(this, o);
    }

    public Identifier I;
    public Expression E;

}
