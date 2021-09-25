package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class EndRestOfIF extends Command {
    public EndRestOfIF(Command cAST, SourcePosition thePosition) {
        super(thePosition);

        C = cAST;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitEndRestOfIf(this, o); }

    public Command C;
}
