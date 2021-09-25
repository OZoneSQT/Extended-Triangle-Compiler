package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatForRangeWhileCommand extends Command {
    public RepeatForRangeWhileCommand(Declaration rvdAST, Expression e2AST, Expression e3AST_while, Command cAST_for_while, SourcePosition thePosition) {
        super(thePosition);
        RVD = rvdAST;
        E1 = e2AST;
        E2 = e3AST_while;
        C = cAST_for_while;

    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatForRangeWhileCommand(this, o);
    }

    public Declaration RVD;
    public Expression E1;
    public Expression E2;
    public Command C;
}
