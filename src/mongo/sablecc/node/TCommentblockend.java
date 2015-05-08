/* This file was generated by SableCC (http://www.sablecc.org/). */

package mongo.sablecc.node;

import mongo.sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TCommentblockend extends Token
{
    public TCommentblockend()
    {
        super.setText("*/");
    }

    public TCommentblockend(int line, int pos)
    {
        super.setText("*/");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TCommentblockend(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCommentblockend(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TCommentblockend text.");
    }
}
