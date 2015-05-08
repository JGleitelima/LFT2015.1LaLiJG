/* This file was generated by SableCC (http://www.sablecc.org/). */

package mongo.sablecc.node;

import mongo.sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TRsbrack extends Token
{
    public TRsbrack()
    {
        super.setText("]");
    }

    public TRsbrack(int line, int pos)
    {
        super.setText("]");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TRsbrack(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTRsbrack(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TRsbrack text.");
    }
}
