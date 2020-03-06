# Issue with ViewModel navigation scope

Assuming we have one fragment (**Home**) that can go to a nested navigation graph (called scope) containing 3 fragments (**A** **B** and **C**).
Those 3 fragments share the same viewmodel, using navGraphViewModels(R.id.scope)
The **A** fragment go to **B** fragment, which go to **C**.
**C** is a terminal Fragment and the popbackstack should go back to **Home**.
Unfortunatelly, requiring this behavior makes **C** have a new instance of the viewmodel instead of the shared one.
This behavior is caused by using popBackStack to **Home**. The popInclusive **true** or **false** doesn't matter.
I understand the reason for this, but from an App developper point of view, it doesn't make sense that my last fragment in my scope/nested graph can't share the viewmodel. 