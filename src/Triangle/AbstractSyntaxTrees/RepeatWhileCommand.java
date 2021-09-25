package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatWhileCommand extends Command {
    public RepeatWhileCommand(Expression eAST_while, Command cAST_while, SourcePosition thePosition) {
        super(thePosition);
        E = eAST_while;
        C = cAST_while;

    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitRepeatWhileCommand(this, o); }

    public Expression E;
    public Command C;
}
