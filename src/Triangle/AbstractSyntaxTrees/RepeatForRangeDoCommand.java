package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatForRangeDoCommand extends Command {
    public RepeatForRangeDoCommand(Declaration rvdAST, Expression e2AST, Command cAST_for_do, SourcePosition thePosition) {
        super(thePosition);
        RVD = rvdAST;
        E2 = e2AST;
        C = cAST_for_do;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitRepeatForRangeDoCommand(this, o); }

    public Declaration RVD;
    public Expression E2;
    public Command C;

}
