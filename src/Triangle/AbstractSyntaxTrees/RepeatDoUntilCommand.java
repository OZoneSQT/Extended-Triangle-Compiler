package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatDoUntilCommand extends Command {
    public RepeatDoUntilCommand(Command cAST_do, Expression eAST_do, SourcePosition thePosition) {
        super(thePosition);
        C = cAST_do;
        E = eAST_do;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitRepeatDoUntilCommand(this, o); }

    public Command C;
    public Expression E;
}
