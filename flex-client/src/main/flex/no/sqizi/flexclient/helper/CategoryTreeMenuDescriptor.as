package no.sqizi.flexclient.helper {
import mx.collections.ICollectionView;
import mx.controls.menuClasses.IMenuDataDescriptor;

public class CategoryTreeMenuDescriptor implements IMenuDataDescriptor{
    public function CategoryTreeMenuDescriptor() {
    }


    public function getChildren(node:Object, model:Object = null):ICollectionView {
        return node.children;
    }

    public function hasChildren(node:Object, model:Object = null):Boolean {
        return node.children.length > 0;
    }

    public function getData(node:Object, model:Object = null):Object {
        return node;
    }

    public function isBranch(node:Object, model:Object = null):Boolean {
        return hasChildren(node, model);
    }

    public function getType(node:Object):String {
        return "normal";
    }

    public function addChildAt(parent:Object, newChild:Object, index:int,
                               model:Object = null):Boolean {
        return false;
    }

    public function removeChildAt(parent:Object, child:Object, index:int,
                                  model:Object = null):Boolean {
        return false;
    }

    public function isEnabled(node:Object):Boolean {
        return true;
    }

    public function setEnabled(node:Object, value:Boolean):void {
    }

    public function isToggled(node:Object):Boolean {
        return false;
    }

    public function setToggled(node:Object, value:Boolean):void {
    }

    public function getGroupName(node:Object):String {
        return null;
    }
}
}