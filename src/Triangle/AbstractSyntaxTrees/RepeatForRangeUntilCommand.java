package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatForRangeUntilCommand extends Command {
    public RepeatForRangeUntilCommand(Declaration rvdAST, Expression e2AST, Expression e3AST_until, Command cAST_for_until, SourcePosition thePosition) {
        super(thePosition);
        RVD = rvdAST;
        E2 = e2AST;
        E3 = e3AST_until;
        C = cAST_for_until;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatForRangeUntilCommand(this, o);
    }

    public Declaration RVD;
    public Expression E2;
    public Expression E3;
    public Command C;
}
