package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatUntilCommand extends Command {
    public RepeatUntilCommand(Expression eAST_until, Command cAST_until, SourcePosition thePosition) {
        super(thePosition);
        E = eAST_until;
        C = cAST_until;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitRepeatUntilCommand(this, o); }

    public Expression E;
    public Command C;
}
