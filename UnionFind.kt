/**
 * UnionFind
 * Each node corresponds to a number (0..`size`-1)
 */
class UnionFind(size:Int){
    private val parents: Array<Int?> =  arrayOfNulls(size)
    private val sizes: Array<Int> =  Array(size) {1}

    /**
     * Returns the root node of `node`.
     */
    fun root(node: Int):Int{
        return parents[node]?.let{
            parents[node]=root(it)
            parents[node]
        }?: node
    }

    /**
     * Unites two groups that contain node `u` and `v`.
     */
    fun unite(u:Int,v:Int){
        var ur = root(u)
        var vr = root(v)
        if(sizes[ur]>sizes[vr]){
            ur = vr .apply{vr=ur}
        }
        parents[ur] = vr
        sizes[vr] += sizes[ur]
    }

    /**
     * Returns if node `u` and `v` are in the same group.
     */
    fun same(u:Int,v:Int):Boolean = root(u)==root(v)

    /**
     * Returns the size of the group which contains node `u`.
     */
    fun size(u:Int):Int = sizes[root(u)]
}